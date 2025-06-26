package com.green.memoserver;

import com.green.memoserver.model.MemoGetReq;
import com.green.memoserver.model.MemoGetRes;
import com.green.memoserver.model.MemoPostReq;
import com.green.memoserver.model.MemoPutReq;
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
    public String getMemo(@PathVariable int memoId) {
        log.info("memoId={}", memoId);
        return "메모 하나";
    }


    //Update
    @PutMapping
    public String putMemo(@RequestBody MemoPutReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        return "수정 성공";
    }

    //Delete
    @DeleteMapping
    public String deleteMemo(@RequestParam(name = "memo_id") int memoId) {
        log.info("memoId={}", memoId);
        return "삭제 성공";
    }
}
