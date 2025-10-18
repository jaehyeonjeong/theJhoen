package com.definejae234.board.controller;

import com.definejae234.board.dao.BoardDao;
import com.definejae234.board.dto.BoardDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardDao  boardDao;

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> boardDtoList = boardDao.findAll();
        model.addAttribute("boardDtoList", boardDtoList);
        return "board/list";
    }

    // data write 후 list에 출력
    // Get/Post 둘다 사용할 수 있다.
    @GetMapping("/write")
    public String boardWrite(Model model){
        // write.html 출력
        model.addAttribute("boardDto", new BoardDto());
        return "board/write";
    }

    @PostMapping("/write")
//    @ResponseBody
    public String boardWriteProcess(@Valid @ModelAttribute BoardDto boardDto,
                                    BindingResult bindingResult,
                                    Model model){
        if (bindingResult.hasErrors()) {
//            model.addAttribute("msg", true);
            return "board/write";
        }
        int result = boardDao.writeBoard(boardDto);
        System.out.println(result);
        return "redirect:../board/list";
    }

    // list에 있는 데이터의 detail을 출력
    @GetMapping("/detail/{id}")
    public String boarderList(@PathVariable("id") int id, Model model){
        BoardDto findedBoard = boardDao.findById(id);
        model.addAttribute("findBoard",findedBoard);
        return "board/detail";
    }

    // 삭제할 아이디를 찾는 Get 컨트롤을 구현
    @GetMapping("/{id}/delete")
    public String deleteBoard(@PathVariable("id") int id, Model model){
        BoardDto findedBoard = boardDao.findById(id);
        model.addAttribute("findBoard",findedBoard);
        return "board/delete";
    }

    // post를 통해서 db데이터 삭제후 리스트의 내용을 출력
    @PostMapping("/delete")
    public String deleteBoardProcess(@ModelAttribute BoardDto boardDto){
        int result = boardDao.deleteBoard(boardDto);
        System.out.println("deleteBoardProcess : " + boardDto.getId() + ", " + boardDto.getPassword());
        System.out.println(result);
        return "redirect:../board/list";
    }

    // update 항목
    @GetMapping("/{id}/edit")
    public String boardEdit(@PathVariable("id") int id, Model model){
        // edit.html 출력
        BoardDto findedBoard = boardDao.findById(id);
        model.addAttribute("findBoard",findedBoard);
        return "board/edit";
    }

    @PostMapping("/edit")
    public String boardEditProcess(@ModelAttribute BoardDto board){
        int result = boardDao.updateBoard(board);
        System.out.println("BoardController.boardEditProcess = " + result);
        return "redirect:../board/list";
    }

}
