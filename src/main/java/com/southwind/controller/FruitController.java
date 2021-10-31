package com.southwind.controller;


import com.southwind.entity.Fruit;
import com.southwind.service.FruitService;
import com.southwind.vo.BarVO;
import com.southwind.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-03-31
 */
@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/list")
    public List<Fruit> list(){
        return this.fruitService.list();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return this.fruitService.removeById(id);
    }

    @GetMapping("/find/{id}")
    public Fruit find(@PathVariable("id") Integer id){
        return this.fruitService.getById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Fruit fruit){
        return this.fruitService.updateById(fruit);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Fruit fruit){
        return this.fruitService.save(fruit);
    }

    @GetMapping("/barVO")
    public BarVO barVO(){
        return this.fruitService.barVOList();
    }

    @GetMapping("/pieVO")
    public List<PieVO> pieVO(){
        return this.fruitService.pieVOList();
    }
}

