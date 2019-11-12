package com.soa.uploadservice.remote;

import com.soa.uploadservice.pojo.BookInfo;
import com.soa.uploadservice.pojo.Stand_Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@Primary
@FeignClient(name= "spring-cloud-Book",fallback = BookRemoteHystrix.class)
public interface BookRemote {
    //新建书籍信息
    @PostMapping("/Book")
    public Stand_Result NewBook(@RequestBody BookInfo bookInfo);
    //修改书籍信息
    @PutMapping("/Book")
    public Stand_Result ModifyBook(@RequestBody BookInfo bookInfo);
    //删除书籍信息
    @DeleteMapping("/Book")
    public Stand_Result DeleteBook(@RequestParam(value = "id") String id);
}
