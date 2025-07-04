package com.green.memoserver;

import com.green.memoserver.config.model.ResultResponse;
import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
//공통 URL
@RequestMapping("/api/memo")
public class MemoController {
    private final MemoService memoService;

    //Create
    @PostMapping
    public ResultResponse<Integer> postMemo(@RequestBody MemoPostReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        int result = memoService.save(req);
        return new ResultResponse<>("삽입 성공", result);
    }

    //Read
    @GetMapping
    public ResultResponse<List<MemoGetRes>> getMemo(@ModelAttribute MemoGetReq req) {
        log.info("req={}", req);
        List<MemoGetRes> result = memoService.findAll(req);
        String message = String.format("rows: %d", result.size());
        return new ResultResponse<>(message, result);
    }

    @GetMapping("/{memoId}")
    public ResultResponse<MemoGetOneRes> getMemo(@PathVariable int memoId) {
        log.info("memoId={}", memoId);
        MemoGetOneRes result = memoService.findById(memoId);
        return new ResultResponse<>("조회 성공", result);
    }

    @GetMapping("/ddd/ddd")
    public String ddd() {
        return "ddd";
    }


    //Update
    @PutMapping
    public ResultResponse<Integer> putMemo(@RequestBody MemoPutReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        int result = memoService.modify(req);
        return new ResultResponse<>("수정 성공", result);
    }

    //Delete
    @DeleteMapping
    public ResultResponse<Integer> deleteMemo(@RequestParam(name = "memo_id") int memoId) {
        log.info("memoId={}", memoId);
        int result = memoService.deleteById(memoId);
        return new ResultResponse<>("삭제 성공", result);
    }
}
