package com.ha.healthauditlog.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ha.healthauditlog.config.DataSourceConfig;
import com.ha.healthauditlog.model.Complications;
import com.ha.healthauditlog.model.PatientDetails;
import com.ha.healthauditlog.model.Sample;
import com.ha.healthauditlog.model.SignUp;
import com.ha.healthauditlog.service.PatientService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@Controller
public class PatientController {
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	PatientService patientService;
	@Autowired
	DataSourceConfig dataSourceConfig;
		
	@RequestMapping("/")
	public String welcome() {
	  return "app.welcome";
	}
	@RequestMapping("/welcome")
	public String welcome1() {
	  return "app.welcome";
	}
	@RequestMapping("/signup.htm")
	public String signup() {
	  return "app.signup";
	}
	
	@RequestMapping(value = "/saveSignUp.htm", method = RequestMethod.POST)
	public RedirectView saveDetails(@ModelAttribute("signUp") SignUp signUp,
			RedirectAttributes attributes,HttpSession session ,Principal principal) {
		//System.out.println("item name "+signUp.getItemName());
		attributes = patientService.saveSignUp(signUp, attributes, principal);
		return new RedirectView("signup.htm", true);
	}
	@RequestMapping(value = "/patientDetails.htm", method = RequestMethod.GET)
	public ModelAndView getPatientDetails() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patientDetailsList",patientService.findAllPatientDetails()); 
		mav.addObject("userList",patientService.findAllUser()); 
		mav.addObject("referalList",patientService.findAllReferal()); 
		mav.addObject("contraceptionList",patientService.findAllcontraception());
		mav.addObject("commentList",patientService.findAllComment());
		mav.setViewName("patientDetails");
		return mav;
		
	}
	@RequestMapping(value = "/savePatientDetails.htm", method = RequestMethod.POST)
	public RedirectView savePatientDetails(@ModelAttribute("patientDetails") PatientDetails patientDetails,
		RedirectAttributes attributes,HttpSession session ,Principal principal) {
		attributes = patientService.savePatientDetails(patientDetails, attributes, principal);
		return new RedirectView("patientDetails.htm", true);
	}
	
	@RequestMapping(value = "/patientDetails.htm", method = RequestMethod.POST)
	public ModelAndView editPatientDetails(@RequestParam("patientId")Long patientId,HttpSession session, Principal principal) {
		ModelAndView mav = new ModelAndView();
		//User user = userService.findByUsername(principal.getName());
		mav.addObject("patientDetailsList",patientService.findAllPatientDetails()); 
		mav.addObject("userList",patientService.findAllUser()); 
		mav.addObject("referalList",patientService.findAllReferal()); 
		mav.addObject("contraceptionList",patientService.findAllcontraception());
		mav.addObject("commentList",patientService.findAllComment());
		mav.addObject("patientDetailsById",patientService.findOnePatientDetails(patientId)); 
		mav.setViewName("patientDetails");
		return mav;
    }
	@RequestMapping(value = "/sampleDetails.htm", method = RequestMethod.GET)
	public ModelAndView getSampleDetails() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patientDetailsList",patientService.findAllPatientDetails());
		mav.addObject("sampleResultList",patientService.findAllSampleResults());
		mav.addObject("sampleResult1List",patientService.findAllSampleResults1());
		mav.addObject("sampleResult2List",patientService.findAllSampleResults2());
		mav.addObject("sampleResult3List",patientService.findAllSampleResults3());
		mav.addObject("sampleAction1List",patientService.findAllSampleActions1());
		mav.addObject("sampleAction2List",patientService.findAllSampleActions2());
		mav.addObject("sampleAction3List",patientService.findAllSampleActions3());
		mav.addObject("sampleAction4List",patientService.findAllSampleActions4());
		mav.setViewName("sample");
		return mav;
		
	}
	@RequestMapping(value = "/createSample.htm", method = RequestMethod.POST)
	public RedirectView saveSampleDetails(@ModelAttribute("sample") Sample sample,
			RedirectAttributes attributes,HttpSession session ,Principal principal) {
		//System.out.println("item name "+signUp.getItemName());
		attributes = patientService.saveSampleDetails(sample, attributes, principal);
		return new RedirectView("sampleDetails.htm", true);
	}
	@RequestMapping(value = "/complicationDetails.htm", method = RequestMethod.GET)
	public ModelAndView getComplicationDetails() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("complicationDetailsList",patientService.findAllComplicationDetails()); 
		mav.addObject("patientDetailsList",patientService.findAllPatientDetails()); 
		mav.setViewName("complicationsDetails");
		return mav;
		
	}
	@RequestMapping(value = "/saveComplicationDetails.htm", method = RequestMethod.POST)
	public RedirectView saveComplicationDetails(@ModelAttribute("complications") Complications complications,
			RedirectAttributes attributes,HttpSession session ,Principal principal) {
			attributes = patientService.saveComplicationDetails(complications, attributes, principal);
		return new RedirectView("complicationDetails.htm", true);
	}
	@RequestMapping(value = "/complicationDetails.htm", method = RequestMethod.POST)
	public ModelAndView editComplicationDetails(@RequestParam("complicationId")Long complicationId,HttpSession session, Principal principal) {
		ModelAndView mav = new ModelAndView();
		//User user = userService.findByUsername(principal.getName());
		mav.addObject("complicationDetailsList",patientService.findAllComplicationDetails()); 
		mav.addObject("patientDetailsList",patientService.findAllPatientDetails()); 
		mav.addObject("complicationDetailsById",patientService.findOneComplicationDetails(complicationId)); 
		mav.setViewName("complicationsDetails");
		return mav;
    }
	@RequestMapping(path = "/pdf", method = RequestMethod.GET)
	@ResponseBody
	public Object report(HttpServletResponse response) {

		InputStream kitchenReportStream = getClass().getResourceAsStream("/report/patientdetails.jrxml");
			JasperReport jasperReport=null;
			try {
				jasperReport = JasperCompileManager.compileReport(kitchenReportStream);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		JasperPrint jasperPrint=null;
		try {
			
				jasperPrint = JasperFillManager.fillReport(
				jasperReport, null, dataSourceConfig.dataSource().getConnection());
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JRPdfExporter exporter = new JRPdfExporter();
		 
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(
		  new SimpleOutputStreamExporterOutput("patients.pdf"));
		 
		SimplePdfReportConfiguration reportConfig
		  = new SimplePdfReportConfiguration();
		reportConfig.setSizePageToContent(true);
		reportConfig.setForceLineBreakPolicy(false);
		 
		SimplePdfExporterConfiguration exportConfig
		  = new SimplePdfExporterConfiguration();
		exportConfig.setMetadataAuthor("baeldung");
		exportConfig.setEncrypted(true);
		exportConfig.setAllowedPermissionsHint("PRINTING");
		exporter.setConfiguration(reportConfig);
		exporter.setConfiguration(exportConfig);
		
		 
		try {
			exporter.exportReport();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 	response.setContentType("application/x-pdf");
	        response.setHeader("Content-disposition", "inline;filename=" + "patient.pdf");

	        OutputStream outStream;
			try {
				outStream = response.getOutputStream();
			
	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outStream));
	       // exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
	        
				exporter.exportReport();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	
}
