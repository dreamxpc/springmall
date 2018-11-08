package com.example.springmall.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	int currentPage = 0;
	int rowPerPage = 10;
	int totalCount;

	public int getSampleCount() {
		return totalCount = sampleMapper.selectSampleCount();
	}

	public List<Sample> getSampleAll(int startRow) {
		return sampleMapper.selectSampleAll(startRow, rowPerPage);
	}

	public int removeSample(int sampleNo) {
		int result = sampleMapper.deleteSample(sampleNo);
		if (result == 1) {
			System.out.println("remove success");
		} else {
			System.out.println("remove fail");
		}
		return result;
	}

	public int addSample(Sample sample) {
		return sampleMapper.insertSample(sample);
	}

	public Sample getSample(int sampleNo) {
		return sampleMapper.selectOne(sampleNo);
	}

	public int modifySample(Sample sample) {
		return sampleMapper.updateSample(sample);
	}
}
