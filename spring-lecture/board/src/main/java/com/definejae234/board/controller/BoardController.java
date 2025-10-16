package com.definejae234.board.controller;

import com.definejae234.board.dao.BoardDao;
import com.definejae234.board.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    // Get/Post 둘다 사용할 수 있다.
    @GetMapping("/write")
    public String boardWrite(Model model){
        // write.html 출력
        model.addAttribute("boardDto", new BoardDto());
        return "board/write";
    }

    @PostMapping("/write")
//    @ResponseBody
    public String boardWriteProcess(@ModelAttribute BoardDto boardDto){
//        System.out.println(member.getUserID()+"==="+
//                member.getUserName()+"==="+
//                member.getUserEmail());
        int result = boardDao.writeBoard(boardDto);
        System.out.println(result);
        return "redirect:../board/list";
    }


}
