package com.soa.uploadservice.remote;

import com.soa.uploadservice.pojo.Book;
import com.soa.uploadservice.pojo.Stand_Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

@Primary
@FeignClient(name= "inventory-service",fallback = InventoryRemoteHystrix.class)
public interface InventoryRemote {
    //新建库存
    @PostMapping("/Inventory")
    public String  NewInventory(@RequestBody Book book);

    //修改库存
    @PutMapping("/Inventory")
    public Stand_Result Update(@RequestBody Book book);

    //删除库存
    @DeleteMapping("/Inventory")
    public Stand_Result DeleteInventory(@RequestParam(value = "id") String id);
}
