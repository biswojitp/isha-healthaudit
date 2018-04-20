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
@Table(name="t_patient")
public class PatientDetails implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue(generator="id")
	
	@Column(name="patient_id")
	private Long patientId;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="doc")
	private Date doc;
	
	@Column(name="next_doc")
	private Date nextDoc;
	
	@Column(name="referal_source")
	private String referalSource;
	
	@Column(name="no_of_child")
	private String noOfChild;
	
	@Column(name="current_contraception")
	private String currentContraception;
	
	
	@ManyToOne
	@JoinColumn(name="userId")
	private SignUp signUp;
	
	@Column(name="dop")
	private Date dop;
	
	@Column(name="procedure_name")
	private String procedureName;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="specific_comment")
	private String specificComment;
	
	@Column(name="pre_anxiolytic")
	private String preAnxiolytic;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoc() {
		return doc;
	}

	public void setDoc(Date doc) {
		this.doc = doc;
	}

	public Date getNextDoc() {
		return nextDoc;
	}

	public void setNextDoc(Date nextDoc) {
		this.nextDoc = nextDoc;
	}

	public String getReferalSource() {
		return referalSource;
	}

	public void setReferalSource(String referalSource) {
		this.referalSource = referalSource;
	}

	public String getNoOfChild() {
		return noOfChild;
	}

	public void setNoOfChild(String noOfChild) {
		this.noOfChild = noOfChild;
	}

	public String getCurrentContraception() {
		return currentContraception;
	}

	public void setCurrentContraception(String currentContraception) {
		this.currentContraception = currentContraception;
	}

	public SignUp getSignUp() {
		return signUp;
	}

	public void setSignUp(SignUp signUp) {
		this.signUp = signUp;
	}

	public Date getDop() {
		return dop;
	}

	public void setDop(Date dop) {
		this.dop = dop;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSpecificComment() {
		return specificComment;
	}

	public void setSpecificComment(String specificComment) {
		this.specificComment = specificComment;
	}

	public String getPreAnxiolytic() {
		return preAnxiolytic;
	}

	public void setPreAnxiolytic(String preAnxiolytic) {
		this.preAnxiolytic = preAnxiolytic;
	}
	
	
	
}
