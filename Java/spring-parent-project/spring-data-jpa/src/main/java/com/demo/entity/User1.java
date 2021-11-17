package com.demo.entity;

/*@Entity
@NamedEntityGraph(name = "bankInfo.detail", attributeNodes = { @NamedAttributeNode("bank") })
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "userAuthenticationAdmin",
							procedureName = "VALIDATEUSERACCOUNT", 
							parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_corpId", type = String.class),
										  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_username", type = String.class), 
										  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_password", type = String.class), 
										  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_message", type = Integer.class)}),
@NamedStoredProcedureQuery(name = "userAuthentication",
procedureName = "VALIDATEUSERACCOUNT", 
parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_corpId", type = String.class),
			  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_username", type = String.class), 
			  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_password", type = String.class), 
			  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_message", type = Integer.class),
			  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_appid", type = String.class)})})
@Table(name = "JCB_USER")*/
public class User1 {
	
	/*private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USER_SEQ", sequenceName = "JCB_USER_SEQID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@Column(name = "AUTO_ID")
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="BANKID",nullable=false,insertable=false,updatable=false)
	private Bank bank;

	@Column(name = "BANKID", nullable = false)
	private String bankId;

	@Column(name = "USERID", nullable = false, length = 15)
	private String userId;

	@Column(name = "USERNAME", length = 40)
	private String userName;

	@Column(name = "LASTLOGGEDINDATE")
	private Date lastLoggedInDate;

	@Column(name = "LOGIN_CURRENT_TIME")
	private Timestamp loginCurrentTime;
	
	@Column(name = "PREV_LOGGED_TIME",insertable=false,updatable=false)
	private Timestamp prevLoggedTime;

	@Column(name = "CORPUSER", nullable = false, length = 1)
	private Integer corpUser;

	@Column(name = "USER_ACTIVE", nullable = false, length = 1)
	private Integer status;

	@Column(name = "MAKERCHECKER")
	private String role;

	@Column(name = "CHANGEPWDONFIRSTLOGIN", nullable = false, length = 1)
	private Integer changePwdOnFirstLogin;

	@Column(name = "PWD")
	private String pwd;
	
	@Column(name = "ACT_START_DATE")
	private Date startDate;
	
	@Column(name = "ACT_END_DATE")
	private Date endDate;
	
	@Column(name = "APP_ACCESS")
	private Integer applAccess;
	
	@Column(name = "EMAIL_ID")
	private String emailId;

	@Transient
	private List<ContextIdRole> contextIdList;
	
	@Transient
	private Boolean isAdd = false;
	
	@Transient
	private Boolean isDelete = false;
	
	@Transient
	private Boolean isModified = false;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public Date getLastLoggedInDate() {
		return lastLoggedInDate;
	}

	public void setLastLoggedInDate(final Date lastLoggedInDate) {
		this.lastLoggedInDate = lastLoggedInDate;
	}

	public Timestamp getLoginCurrentTime() {
		return loginCurrentTime;
	}

	public void setLoginCurrentTime(Timestamp loginCurrentTime) {
		this.loginCurrentTime = loginCurrentTime;
	}

	public Timestamp getPrevLoggedTime() {
		return prevLoggedTime;
	}

	public void setPrevLoggedTime(Timestamp prevLoggedTime) {
		this.prevLoggedTime = prevLoggedTime;
	}

	public Integer getCorpUser() {
		return corpUser;
	}

	public void setCorpUser(final Integer corpUser) {
		this.corpUser = corpUser;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getChangePwdOnFirstLogin() {
		return changePwdOnFirstLogin;
	}

	public void setChangePwdOnFirstLogin(final Integer changePwdOnFirstLogin) {
		this.changePwdOnFirstLogin = changePwdOnFirstLogin;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(final String pwd) {
		this.pwd = pwd;
	}

	public List<ContextIdRole> getContextIdList() {
		return contextIdList;
	}

	public void setContextIdList(final List<ContextIdRole> contextIdList) {
		this.contextIdList = contextIdList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsModified() {
		return isModified;
	}

	public void setIsModified(Boolean isModified) {
		this.isModified = isModified;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getApplAccess() {
		return applAccess;
	}

	public void setApplAccess(Integer applAccess) {
		this.applAccess = applAccess;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Boolean getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(Boolean isAdd) {
		this.isAdd = isAdd;
	}*/
}
