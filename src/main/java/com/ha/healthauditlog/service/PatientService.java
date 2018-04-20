package com.ha.healthauditlog.service;

import java.security.Principal;
import java.util.List;

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

public interface PatientService {

	RedirectAttributes saveSignUp(SignUp signUp, RedirectAttributes attributes, Principal principal);

	List<PatientDetails> findAllPatientDetails();

	RedirectAttributes saveSampleDetails(Sample sample, RedirectAttributes attributes, Principal principal);

	RedirectAttributes savePatientDetails(PatientDetails patientDetails, RedirectAttributes attributes,
			Principal principal);

	List<SignUp> findAllUser();

	List<Referal> findAllReferal();

	List<Contraception> findAllcontraception();

	List<Comment> findAllComment();

	PatientDetails findOnePatientDetails(Long patientId);

	List<Complications> findAllComplicationDetails();

	RedirectAttributes saveComplicationDetails(Complications complications, RedirectAttributes attributes,
			Principal principal);

	Complications findOneComplicationDetails(Long complicationId);

	List<SampleResult> findAllSampleResults();
	List<SampleResult1> findAllSampleResults1();
	List<SampleResult2> findAllSampleResults2();
	List<SampleResult3> findAllSampleResults3();
	List<SampleAction1> findAllSampleActions1();
	List<SampleAction2> findAllSampleActions2();
	List<SampleAction3> findAllSampleActions3();
	List<SampleAction4> findAllSampleActions4();

}
