package com.example.springmall.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService;

	// 1. sampleList
	@RequestMapping(value = "/sample/sampleList", method = RequestMethod.GET)
	public String sampleList(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "0") int currentPage) {
		System.out.println("SampleController - sampleList");
		List<Sample> sampleList = sampleService.getSampleAll(currentPage);
		int totalCount = sampleService.getSampleCount();
		model.addAttribute("sampleList", sampleList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalCount", totalCount);
		return "/sample/sampleList";
	}

	// 2. delete
	@RequestMapping(value = "/sample/removeSample", method = RequestMethod.GET)
	public String removeSample(@RequestParam(value = "sampleNo") int sampleNo) {
		if (sampleService.removeSample(sampleNo) == 1) {
			System.out.println(sampleNo + "번 데이터 삭제 성공");
		}
		return "redirect:/sample/sampleList";
	}

	// 3-1. addForm
	@RequestMapping(value = "/sample/addSample", method = RequestMethod.GET)
	public String addSample() {
		System.out.println("addForm");
		return "/sample/addSample";
	}

	// 3-2. addAction
	@RequestMapping(value = "/sample/addSample", method = RequestMethod.POST)
	public String addSample(Sample sample) {
		System.out.println("addAction");
		if (sampleService.addSample(sample) == 1) {
			System.out.println("add success");
		}
		return "redirect:/sample/sampleList";
	}

	// 4-1. modifyForm
	@RequestMapping(value = "/sample/modifySample", method = RequestMethod.GET)
	public String modifySample(Model model, @RequestParam(value = "sampleNo") int sampleNo) {
		System.out.println("modifyForm");
		Sample sample = sampleService.getSample(sampleNo);
		model.addAttribute("sample", sample);
		return "/sample/modifySample";
	}

	// 4-2. modifyAction
	@RequestMapping(value = "/sample/modifySample", method = RequestMethod.POST)
	public String modifySample(Sample sample) {
		System.out.println("modifyAction");
		if (sampleService.modifySample(sample) == 1) {
			System.out.println("modify success");
		}
		return "redirect:/sample/sampleList";
	}
}
