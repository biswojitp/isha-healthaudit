package com.ha.healthauditlog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="t_complication")

public class Complications implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue(generator="id")
	
	@Column(name="complication_id")
	private Long complicationId;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private PatientDetails patientDetails;
	
	@Column(name="complication_section")
	private String complicationSection;
	
	@Column(name="doc")
	private Date doc;
	
	@Column(name="time_after_procedure")
	private String timeAfterProcedure;
	
	@Column(name="infection")
	private Boolean infection;
	
	@Column(name="small_hematoma")
	private String smallHematoma;
	
	@Column(name="large_hematoma")
	private String largeHematoma;
	
	@Column(name="chronic_scrotal_pain")
	private String chronicScrotalPain;
	
	@Column(name="pain_on_ejaculation")
	private String painOnEjaculation;
	
	@Column(name="haematospermia")
	private String haematospermia;
	
	@Column(name="description")
	private String description;

	public Long getComplicationId() {
		return complicationId;
	}

	public void setComplicationId(Long complicationId) {
		this.complicationId = complicationId;
	}

	public PatientDetails getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}

	public String getComplicationSection() {
		return complicationSection;
	}

	public void setComplicationSection(String complicationSection) {
		this.complicationSection = complicationSection;
	}

	public Date getDoc() {
		return doc;
	}

	public void setDoc(Date doc) {
		this.doc = doc;
	}

	public String getTimeAfterProcedure() {
		return timeAfterProcedure;
	}

	public void setTimeAfterProcedure(String timeAfterProcedure) {
		this.timeAfterProcedure = timeAfterProcedure;
	}

	public Boolean getInfection() {
		return infection;
	}

	public void setInfection(Boolean infection) {
		this.infection = infection;
	}

	public String getSmallHematoma() {
		return smallHematoma;
	}

	public void setSmallHematoma(String smallHematoma) {
		this.smallHematoma = smallHematoma;
	}

	public String getLargeHematoma() {
		return largeHematoma;
	}

	public void setLargeHematoma(String largeHematoma) {
		this.largeHematoma = largeHematoma;
	}

	public String getChronicScrotalPain() {
		return chronicScrotalPain;
	}

	public void setChronicScrotalPain(String chronicScrotalPain) {
		this.chronicScrotalPain = chronicScrotalPain;
	}

	public String getPainOnEjaculation() {
		return painOnEjaculation;
	}

	public void setPainOnEjaculation(String painOnEjaculation) {
		this.painOnEjaculation = painOnEjaculation;
	}

	public String getHaematospermia() {
		return haematospermia;
	}

	public void setHaematospermia(String haematospermia) {
		this.haematospermia = haematospermia;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
