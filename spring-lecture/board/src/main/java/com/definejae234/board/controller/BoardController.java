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
//    @GetMapping("/board/detail/{id}")
//    public String memberList(@PathVariable("id") int id, Model model){
//        BoardDto findBoard = boardDao.findById(id);
//        model.addAttribute("findBoard",findBoard);
//        return "board/detail";
//    }
}
