package com.kakarote.module.service;

import com.kakarote.common.servlet.BaseService;
import com.kakarote.module.entity.BO.FileDeleteRequestBO;
import com.kakarote.module.entity.BO.FileRenameRequestBO;
import com.kakarote.module.entity.PO.FileEntity;
import com.kakarote.module.entity.VO.FileEntityVO;
import com.kakarote.module.entity.VO.FileUploadResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : zjj
 * @since : 2023/1/9
 */
public interface IFileEntityService extends BaseService<FileEntity> {

    /**
     * 文件上传
     *
     * @param file      文件对象
     * @param batchId   批次 ID
     * @param overwrite 重写
     * @param type      文件类型
     * @param isPublic  是否公有
     * @return
     * @throws IOException
     */
    FileUploadResultVO upload(MultipartFile file,
                              String batchId,
                              Boolean overwrite,
                              String type,
                              Boolean isPublic) throws IOException;

    /**
     * 文件下载
     *
     * @param fileId   文件 ID
     * @param response http 响应
     */
    void download(Long fileId, HttpServletResponse response);

    /**
     * 根据 fileId 删除文件
     *
     * @param fileId 文件 ID
     */
    void deleteById(Long fileId);

    /**
     * 根据 batchId 删除文件
     *
     * @param requestBO
     */
    void deleteByBatchId(FileDeleteRequestBO requestBO);

    /**
     * 文件重命名
     *
     * @param requestBO
     */
    void renameFile(FileRenameRequestBO requestBO);

    /**
     * 查询文件列表
     *
     * @param batchId 批次 ID
     * @return
     */
    List<FileEntityVO> queryFileList(String batchId);

    /**
     * 根据批次 ID 查询文件
     *
     * @param batchId 批次 ID
     * @return
     */
    FileEntityVO queryByBatchId(String batchId);

    /**
     * 根据文件 ID获取文件 URL
     *
     * @param fieldId 文件 ID
     * @return
     */
    String getUrl(Long fieldId);

}
