package com.narel.online_store.сontroller;


import com.narel.online_store.Dto.CPUDto;
import com.narel.online_store.MyException.ValidationException;
import com.narel.online_store.service.CPUService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/cpu")
@AllArgsConstructor
@Log
public class CPUController {


    private final CPUService cpuService;

    @PostMapping("/save")
    public CPUDto saveCpu(@RequestBody CPUDto cpuDto) throws ValidationException{
        log.info("Handling save CPU: " + cpuDto);
        return cpuService.saveCpu(cpuDto);
    }

    @GetMapping("/findAll")
    public List<CPUDto> findAllCpu(){
        log.info("Handling find all CPU request");
        return cpuService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCpu(@PathVariable Long id){
        log.info("Handling delete CPU request: "+ id);
        cpuService.deleteCPU(id);
        return ResponseEntity.ok().build();
    }


    }

