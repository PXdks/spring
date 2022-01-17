package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Booklist;
import com.example.demo.entity.User;
import com.example.demo.mapper.BooklistMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("booklist")
public class BooklistController {
    @Resource
    BooklistMapper booklistMapper;
    @PostMapping
    public Result<?> save(@RequestBody Booklist booklist)
    {

        booklistMapper.insert(booklist);
        return Result.success();
    }
    @GetMapping
    public Result<?>findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "") String search)
    {
        Page<Booklist> BooklistPage=booklistMapper.selectPage(new Page<>(pageNum,pageSize), Wrappers.<Booklist>lambdaQuery().like(Booklist::getName,search));
        return Result.success(BooklistPage);
    }
}
