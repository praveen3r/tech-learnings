/*package com.demo.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.FileUploadVO;
import com.demo.entity.FileUpload;

public interface FileUploadRepository extends JpaRepository<FileUpload, BigInteger>, FileUploadRepositoryCustom {
	
	@Query("SELECT new com.demo.domain.FileUploadVO(fu.id, pc.productTypeId, pc.productCode, pt.inputFileLocation, pt.responseFileLocation, fu.corpId," + 
		   "fu.uploadedFilename, fu.respondedFilename, fu.recordCount, fu.totalAmount, TO_CHAR(fu.uploadedDatetime,'dd/MM/yyyy HH24:MI:SS'), "  +
		   "TO_CHAR(fu.varifiedDatetime,'dd/MM/yyyy HH24:MI:SS'), uu.userName, uu.userName, uu.id, uu.id, fu.batchId, us.status, us.name, "  +
		   "fu.remark, fu.noVarRequired, fu.fileDuplicate) FROM FileUpload fu JOIN fu.corpProductCode pc JOIN fu.uploadStatus us JOIN fu.uploadedUser uu "  +
		   "JOIN fu.corpProductCode.productType pt WHERE us.status IN ('E') AND fu.corpId=?1 AND uu.id=?2 ORDER BY fu.id DESC")
	List<FileUploadVO> getMakerQueueRecords(String corpId, Long userId);
	
	@Query("SELECT new com.demo.domain.FileUploadVO(fu.id, pc.productTypeId, pc.productCode, pt.inputFileLocation, pt.responseFileLocation, fu.corpId," + 
		   "fu.uploadedFilename, fu.respondedFilename, fu.recordCount, fu.totalAmount, TO_CHAR(fu.uploadedDatetime,'dd/MM/yyyy HH24:MI:SS'), " +
		   "TO_CHAR(fu.varifiedDatetime,'dd/MM/yyyy HH24:MI:SS'), uu.userName, uur.userName, fu.uploadedUser.id, fu.verifiedUser.id, fu.batchId, us.status, us.name, "  +
		   "fu.remark, fu.noVarRequired, fu.fileDuplicate) FROM FileUpload fu JOIN fu.corpProductCode pc JOIN fu.uploadStatus us JOIN fu.uploadedUser uu "  +
		   "JOIN fu.corpProductCode.productType pt LEFT JOIN fu.verifiedUser uur WHERE us.status IN ('U','U1') AND fu.corpId=?1 AND uu.id!=?2 "  +
		   "AND nvl(uur.id,0)!=?2 AND pc.id IN ?3 ORDER BY fu.uploadedDatetime DESC")
	List<FileUploadVO> getCheckerLevelOneRecords(String corpId, Long userId, List<Long> productCodeIds);
	
	@Query("SELECT new com.demo.domain.FileUploadVO(fu.id, pc.productTypeId, pc.productCode, pt.inputFileLocation, pt.responseFileLocation, fu.corpId," + 
			   "fu.uploadedFilename, fu.respondedFilename, fu.recordCount, fu.totalAmount, TO_CHAR(fu.uploadedDatetime,'dd/MM/yyyy HH24:MI:SS'), "  +
			   "TO_CHAR(fu.varifiedDatetime,'dd/MM/yyyy HH24:MI:SS'), uu.userName, uur.userName, fu.uploadedUser.id, fu.verifiedUser.id, fu.batchId, us.status, us.name, " +
			   "fu.remark, fu.noVarRequired, fu.fileDuplicate) FROM FileUpload fu JOIN fu.corpProductCode pc JOIN fu.uploadStatus us JOIN fu.uploadedUser uu " +
			   "JOIN fu.corpProductCode.productType pt LEFT JOIN fu.verifiedUser uur WHERE us.status IN ('U2') AND fu.corpId=?1 AND uu.id!=?2 " +
			   "AND nvl(uur.id,0)!=?2 AND pc.id IN ?3 ORDER BY fu.uploadedDatetime DESC")
		List<FileUploadVO> getCheckerLevelTwoRecords(String corpId, Long userId, List<Long> productCodeIds);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE unbi_fileupload SET status = ?, remark = ? WHERE auto_id = ? ", nativeQuery=true)
	void updateMakerRecords(String status, String remarks, BigInteger entryId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE unbi_fileupload SET status = ?, verifieduser = ?, sent_for_auth = ? WHERE auto_id = ? ", nativeQuery=true)
	void updateCheckerRecords(String status, Long userId, Long authId, BigInteger entryId);
	
	@Query("SELECT new com.demo.domain.FileUploadVO(fu.id, pt.inputFileLocation, pt.bvaInputFileLocation, pt.responseFileLocation, fu.uploadedFilename, " +
			   " fu.batchId, fu.bvaFileName, fu.corpId, pc.fileFormatCodeId, pc.productTypeId) FROM FileUpload fu JOIN fu.uploadStatus us "
			   + "JOIN fu.corpProductCode pc JOIN fu.corpProductCode.productType pt WHERE us.status = 'V'")
	List<FileUploadVO> getPublishFileList();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE unbi_fileupload SET status = ? WHERE auto_id = ? ", nativeQuery=true)
	void updateFilePublishStatus(String status, BigInteger entryId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE unbi_fileupload SET status = ?, successcount = ?, failedcount = ?, respondedFilename = ?  WHERE auto_id = ? ", nativeQuery=true)
	void updateBeneficiaryFileReceiveStatus(String status, Long successCount, Long failedCount, String responseFilename, BigInteger entryId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE unbi_fileupload SET status = ?, successcount = ?, failedcount = ?, respondedFilename = ?  WHERE batchid = ? ", nativeQuery=true)
	void updateFileReceiveStatus(String status, Long successCount, Long failedCount, String responseFilename, String batchId);
	
	@Query("SELECT new com.demo.domain.FileUploadVO(fu.uploadedFilename) FROM FileUpload fu JOIN fu.uploadStatus us "
    		+ "JOIN fu.corpProductCode pc where fu.uploadedFilename = ?1 AND fu.corpId = ?2 AND pc.id = ?3 AND trunc(fu.uploadedDatetime) = trunc(sysdate) "
    		+ "AND us.status NOT IN ('I','D','R')")
    FileUploadVO searchDuplicateFileName(String fileName, String corpId, long productCodeId);
    
    @Query("SELECT new com.demo.domain.FileUploadVO(fu.uploadedFilename) FROM FileUpload fu JOIN fu.uploadStatus us "
    		+ "JOIN fu.corpProductCode pc where fu.recordCount = ?1 AND fu.corpId = ?2 AND fu.totalAmount = ?3 AND pc.id = ?4 AND trunc(fu.uploadedDatetime) = trunc(sysdate) "
    		+ "AND us.status NOT IN ('I','D','R')")
    List<FileUploadVO> searchDuplicateUpload(final Long recordCount, String corpId, BigDecimal totalAmount, long productCodeId);
    
    @Query("SELECT count(fu.id) FROM FileUpload fu JOIN fu.uploadedUser uu LEFT JOIN fu.verifiedUser uur WHERE uu.id = ?1 OR nvl(uur.id,0) = ?1")
	Long getUserRef(long userId);
    
    @Query(value="SELECT fu.AUTO_ID FROM unbi_fileupload fu WHERE fu.corp_productode = ?1 AND fu.corpid = ?2 AND rownum = 1", nativeQuery=true)
    BigInteger getProdRef(final Long productCode, final String corpId);
    
    @Query(value="SELECT fu.AUTO_ID FROM unbi_fileupload fu WHERE fu.corp_productode = ?1 AND fu.corpid = ?2 AND fu.status IN ('P') AND rownum = 1 ", nativeQuery=true)
    BigInteger getProdAcctRef(final Long productCode, final String corpId);
	
	
}
*/