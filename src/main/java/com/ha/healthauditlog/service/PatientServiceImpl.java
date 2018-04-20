package com.ha.healthauditlog.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ha.healthauditlog.model.Comment;
import com.ha.healthauditlog.model.Complications;
import com.ha.healthauditlog.model.Contraception;
import com.ha.healthauditlog.model.PatientDetails;
import com.ha.healthauditlog.model.Referal;
import com.ha.healthauditlog.model.Sample;
import com.ha.healthauditlog.model.SampleAction1;
import com.ha.healthauditlog.model.SampleAction2;
import com.ha.healthauditlog.model.SampleAction3;
import com.ha.healthauditlog.model.SampleAction4;
import com.ha.healthauditlog.model.SampleResult;
import com.ha.healthauditlog.model.SampleResult1;
import com.ha.healthauditlog.model.SampleResult2;
import com.ha.healthauditlog.model.SampleResult3;
import com.ha.healthauditlog.model.SignUp;
import com.ha.healthauditlog.repository.CommentRepository;
import com.ha.healthauditlog.repository.ComplicationsRepository;
import com.ha.healthauditlog.repository.ContraceptionRepository;
import com.ha.healthauditlog.repository.PatientDetailsRepository;
import com.ha.healthauditlog.repository.ReferalRepository;
import com.ha.healthauditlog.repository.SampleAction1Repository;
import com.ha.healthauditlog.repository.SampleAction2Repository;
import com.ha.healthauditlog.repository.SampleAction3Repository;
import com.ha.healthauditlog.repository.SampleAction4Repository;
import com.ha.healthauditlog.repository.SampleRepository;
import com.ha.healthauditlog.repository.SampleResult1Repository;
import com.ha.healthauditlog.repository.SampleResult2Repository;
import com.ha.healthauditlog.repository.SampleResult3Repository;
import com.ha.healthauditlog.repository.SampleResultRepository;
import com.ha.healthauditlog.repository.SignUpRepository;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	SignUpRepository signUpRepository;
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	@Autowired
	SampleRepository sampleRepository;
	@Autowired
	ReferalRepository referalRepository;
	@Autowired
	ContraceptionRepository contraceptionRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	ComplicationsRepository complicationsRepository;
	@Autowired
	SampleResultRepository sampleResultRepository;
	@Autowired
	SampleResult1Repository sampleResult1Repository;
	@Autowired
	SampleResult2Repository sampleResult2Repository;
	@Autowired
	SampleResult3Repository sampleResult3Repository;
	@Autowired
	SampleAction1Repository sampleAction1Repository;
	@Autowired
	SampleAction2Repository sampleAction2Repository;
	@Autowired
	SampleAction3Repository sampleAction3Repository;
	@Autowired
	SampleAction4Repository sampleAction4Repository;





	@Override
	public RedirectAttributes saveSignUp(SignUp signUp, RedirectAttributes attributes, Principal principal) {
		signUpRepository.save(signUp);
		return null;
	}

	@Override
	public List<PatientDetails> findAllPatientDetails() {
		List<PatientDetails> patientList=patientDetailsRepository.findAll();
		return patientList;
	}

	@Override
	public RedirectAttributes saveSampleDetails(Sample sample, RedirectAttributes attributes, Principal principal) {
		sampleRepository.save(sample);
		return null;
	}

	@Override
	public RedirectAttributes savePatientDetails(PatientDetails patientDetails, RedirectAttributes attributes,
			Principal principal) {
		patientDetailsRepository.save(patientDetails);
		return null;
	}

	@Override
	public List<SignUp> findAllUser() {
		
		return signUpRepository.findAll();
	}

	@Override
	public List<Referal> findAllReferal() {
		
		return referalRepository.findAll();
	}

	@Override
	public List<Contraception> findAllcontraception() {
		
		return contraceptionRepository.findAll();
	}

	@Override
	public List<Comment> findAllComment() {
		
		return commentRepository.findAll();
	}

	@Override
	public PatientDetails findOnePatientDetails(Long patientId) {
		
		return patientDetailsRepository.findOne(patientId);
	}

	@Override
	public List<Complications> findAllComplicationDetails() {
		
		return complicationsRepository.findAll();
	}

	@Override
	public RedirectAttributes saveComplicationDetails(Complications complications, RedirectAttributes attributes,
			Principal principal) {
		complicationsRepository.save(complications);
		return null;
	}

	@Override
	public Complications findOneComplicationDetails(Long complicationId) {
		
		return complicationsRepository.findOne(complicationId);
	}

	@Override
	public List<SampleResult> findAllSampleResults() {
		
		return sampleResultRepository.findAll();
	}
	@Override
	public List<SampleResult1> findAllSampleResults1() {
		
		return sampleResult1Repository.findAll();
	}
	@Override
	public List<SampleResult2> findAllSampleResults2() {
		
		return sampleResult2Repository.findAll();
	}
	@Override
	public List<SampleResult3> findAllSampleResults3() {
		
		return sampleResult3Repository.findAll();
	}
	@Override
	public List<SampleAction1> findAllSampleActions1() {
		
		return sampleAction1Repository.findAll();
	}
	@Override
	public List<SampleAction2> findAllSampleActions2() {
		
		return sampleAction2Repository.findAll();
	}
	@Override
	public List<SampleAction3> findAllSampleActions3() {
		
		return sampleAction3Repository.findAll();
	}
	@Override
	public List<SampleAction4> findAllSampleActions4() {
		
		return sampleAction4Repository.findAll();
	}
	
}