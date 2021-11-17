/*package com.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UNBI_FILEUPLOAD")
public class FileUpload implements Serializable {

	private static final long serialVersionUID = -7941226326435429109L;

	@Id
	@SequenceGenerator(name = "FILEUPLOAD_SEQID", sequenceName = "UNBI_FILEUPLOAD_SEQID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILEUPLOAD_SEQID")
	@Column(name = "AUTO_ID", unique = true, nullable = false, updatable = false)
	private BigInteger id;

	@ManyToOne
	@JoinColumn(name = "CORP_PRODUCTODE", nullable = false)
	private ProductCode corpProductCode;

	@Column(name = "UPLOADEDFILENAME", nullable = false)
	private String uploadedFilename;

	@Column(name = "RESPONDEDFILENAME")
	private String respondedFilename;

	@Column(name = "RECORDCOUNT")
	private Long recordCount;

	@Column(name = "TOTALAMOUNT")
	private BigDecimal totalAmount;

	@Column(name = "SUCCESSCOUNT")
	private Long successCount;

	@Column(name = "FAILEDCOUNT")
	private Long failedCount;

	@Column(name = "UPLOADEDDATETIME")
	private Timestamp uploadedDatetime;

	@Column(name = "VARIFIEDDATETIME")
	private Timestamp varifiedDatetime;

	@Column(name = "RESPONSEDATETIME")
	private Timestamp responseDatetime;

	@Column(name = "NO_VAR_REQUIRED")
	private Integer noVarRequired;

	@Column(name = "NO_VAR_COMPLETED")
	private Integer noVarCompleted;

	@Column(name = "BATCHID", nullable = false)
	private String batchId;

	@ManyToOne
	@JoinColumn(name = "UPLOADEDUSER", nullable = false)
	private UnbiUser uploadedUser;

	@ManyToOne
	@JoinColumn(name = "VERIFIEDUSER", nullable = false)
	private UnbiUser verifiedUser;

	@ManyToOne
	@JoinColumn(name = "STATUS", nullable = false)
	private UploadStatus uploadStatus;

	@Column(name = "REMARK")
	private String remark;

	@ManyToOne
	@JoinColumn(name = "SENT_FOR_AUTH", nullable = false)
	private UnbiUser sentForAuth;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="CORPID", nullable=false, insertable=false, updatable=false)
	private Corporate corporate;
	
	@Column(name="CORPID", nullable=false)
	private String corpId;
	
	@Column(name = "BVA_FILENAME")
	private String bvaFileName;
	
	@Column(name = "WARN_OVERRIDE")
	private int fileDuplicate;
	
	@Column(name = "MAKERDATETIME")
	private Timestamp makerDatetime;
	
	@Column(name = "ACCOUNTNO")
	private String accountNo;
	
	@Column(name = "BEN_ENRICH_IND")
	private String isBeneficiaryView;
	
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "UNBI_PAYMENT_BEN_DET", joinColumns = @JoinColumn(name = "FILE_REF_ID"))
	@AttributeOverrides({
        @AttributeOverride(name = "rowNo", column = @Column(name = "ROW_NO")),
        @AttributeOverride(name = "benifRefId", column = @Column(name = "BEN_AUTO_ID")),
        @AttributeOverride(name = "amount", column = @Column(name = "AMOUNT"))
	})
	@SequenceGenerator(name = "PAYMENT_BEN_DET_SEQ_ID", sequenceName = "UNBI_PAYMENT_BEN_DET_SEQ_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_BEN_DET_SEQ_ID")
	@CollectionId(columns = @Column(name="AUTO_ID"), type=@Type(type="long"), generator = "PAYMENT_BEN_DET_SEQ_ID" )
	private List<PaymentBeneficiaryDetails> paymentBeneficiaryDetailsList;
	
	public BigInteger getId() {
		return id;
	}

	public void setId(final BigInteger id) {
		this.id = id;
	}

	public ProductCode getCorpProductCode() {
		return corpProductCode;
	}

	public void setCorpProductCode(final ProductCode corpProductCode) {
		this.corpProductCode = corpProductCode;
	}

	public String getUploadedFilename() {
		return uploadedFilename;
	}

	public void setUploadedFilename(final String uploadedFilename) {
		this.uploadedFilename = uploadedFilename;
	}

	public String getRespondedFilename() {
		return respondedFilename;
	}

	public void setRespondedFilename(final String respondedFilename) {
		this.respondedFilename = respondedFilename;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(final Long recordCount) {
		this.recordCount = recordCount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(final BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(final Long successCount) {
		this.successCount = successCount;
	}

	public Long getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(final Long failedCount) {
		this.failedCount = failedCount;
	}

	public Timestamp getUploadedDatetime() {
		return uploadedDatetime;
	}

	public void setUploadedDatetime(final Timestamp uploadedDatetime) {
		this.uploadedDatetime = uploadedDatetime;
	}

	public Timestamp getVarifiedDatetime() {
		return varifiedDatetime;
	}

	public void setVarifiedDatetime(final Timestamp varifiedDatetime) {
		this.varifiedDatetime = varifiedDatetime;
	}

	public Timestamp getResponseDatetime() {
		return responseDatetime;
	}

	public void setResponseDatetime(final Timestamp responseDatetime) {
		this.responseDatetime = responseDatetime;
	}

	public Integer getNoVarRequired() {
		return noVarRequired;
	}

	public void setNoVarRequired(final Integer noVarRequired) {
		this.noVarRequired = noVarRequired;
	}

	public Integer getNoVarCompleted() {
		return noVarCompleted;
	}

	public void setNoVarCompleted(final Integer noVarCompleted) {
		this.noVarCompleted = noVarCompleted;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(final String batchId) {
		this.batchId = batchId;
	}

	public UploadStatus getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(final UploadStatus uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(final String remark) {
		this.remark = remark;
	}

	public UnbiUser getSentForAuth() {
		return sentForAuth;
	}

	public void setSentForAuth(final UnbiUser sentForAuth) {
		this.sentForAuth = sentForAuth;
	}

	public UnbiUser getUploadedUser() {
		return uploadedUser;
	}

	public void setUploadedUser(final UnbiUser uploadedUser) {
		this.uploadedUser = uploadedUser;
	}

	public UnbiUser getVerifiedUser() {
		return verifiedUser;
	}

	public void setVerifiedUser(final UnbiUser verifiedUser) {
		this.verifiedUser = verifiedUser;
	}

	public Corporate getCorporate() {
		return corporate;
	}

	public void setCorporate(Corporate corporate) {
		this.corporate = corporate;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getBvaFileName() {
		return bvaFileName;
	}

	public void setBvaFileName(String bvaFileName) {
		this.bvaFileName = bvaFileName;
	}

	public int getFileDuplicate() {
		return fileDuplicate;
	}

	public void setFileDuplicate(int fileDuplicate) {
		this.fileDuplicate = fileDuplicate;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Timestamp getMakerDatetime() {
		return makerDatetime;
	}

	public void setMakerDatetime(Timestamp makerDatetime) {
		this.makerDatetime = makerDatetime;
	}

	public String getIsBeneficiaryView() {
		return isBeneficiaryView;
	}

	public void setIsBeneficiaryView(String isBeneficiaryView) {
		this.isBeneficiaryView = isBeneficiaryView;
	}

	public List<PaymentBeneficiaryDetails> getPaymentBeneficiaryDetailsList() {
		return paymentBeneficiaryDetailsList;
	}

	public void setPaymentBeneficiaryDetailsList(List<PaymentBeneficiaryDetails> paymentBeneficiaryDetailsList) {
		this.paymentBeneficiaryDetailsList = paymentBeneficiaryDetailsList;
	}

}*/