package com.definejae234.board.dao;

import com.definejae234.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    int writeBoard(BoardDto boardDto);
    List<BoardDto> findAll();
    BoardDto findById(int id);
}
