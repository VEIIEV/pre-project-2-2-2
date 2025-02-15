package org.example.preproject222.controller;


import org.example.preproject222.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @GetMapping
    public ResponseEntity<String> approveCredit(@RequestParam Long userId) {
        String verdict = loanService.approveCredit(userId);
        return ResponseEntity.ok(verdict);
    }
}
