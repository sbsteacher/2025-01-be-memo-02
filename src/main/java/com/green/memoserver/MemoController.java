package com.green.memoserver;

import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
//공통 URL
@RequestMapping("api/memo")
public class MemoController {
    private final MemoService memoService;

    //Create
    @PostMapping
    public String postMemo(@RequestBody MemoPostReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        int result =  memoService.save(req);
        return result == 1 ? "저장 성공" : "저장 실패";
    }

    //Read
    @GetMapping
    public List<MemoGetRes> getMemo(@ModelAttribute MemoGetReq req) {
        log.info("req={}", req);
        return memoService.findAll(req);
    }

    @GetMapping("{memoId}")
    public MemoGetOneRes getMemo(@PathVariable int memoId) {
        log.info("memoId={}", memoId);
        return memoService.findById(memoId);
    }


    //Update
    @PutMapping
    public String putMemo(@RequestBody MemoPutReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        return "수정 성공";
    }

    //Delete
    @DeleteMapping
    public int deleteMemo(@RequestParam(name = "memo_id") int memoId) {
        log.info("memoId={}", memoId);
        return memoService.deleteById(memoId);
    }
}
