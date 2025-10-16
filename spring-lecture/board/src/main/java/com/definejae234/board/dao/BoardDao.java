package com.definejae234.board.dao;

import com.definejae234.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    int writeBoard(BoardDto boardDto);
    List<BoardDto> findAll();
    // board.xml에서 id 명칭과 일치해야함.
    BoardDto findById(int id);

    // 삭제는 writeBoard와 마찬가지로 int 타입으로 반환하기 떄문에 타입을 int로 해야한다.
    int deleteBoard(BoardDto boardDto);
}
