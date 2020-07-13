package zuijiu997.outh2.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BaseModuleResources implements Serializable {
    private String id;

    private String moduleName;

    private String moduleCode;

    private String modulePath;

    private String parentId;

    private String moduleIcon;

    private String httpMethod;

    /**
     * 0 否，1 是
     */
    private Integer isOperating;

    private Integer sort;

    private String systemId;

    private Integer active;

    private Date createDate;

    private Date updateDate;

    /**
     * 资源子项
     */
    private List<BaseModuleResources> subModules;

    /**
     * 资源所属系统
     */
    private String projectName;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return MODULE_NAME
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * @return MODULE_CODE
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * @param moduleCode
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * @return MODULE_PATH
     */
    public String getModulePath() {
        return modulePath;
    }

    /**
     * @param modulePath
     */
    public void setModulePath(String modulePath) {
        this.modulePath = modulePath;
    }

    /**
     * @return PARENT_ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return MODULE_ICON
     */
    public String getModuleIcon() {
        return moduleIcon;
    }

    /**
     * @param moduleIcon
     */
    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon;
    }

    /**
     * @return HTTP_METHOD
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * @param httpMethod
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * 获取0 否，1 是
     *
     * @return IS_OPERATING - 0 否，1 是
     */
    public Integer getIsOperating() {
        return isOperating;
    }

    /**
     * 设置0 否，1 是
     *
     * @param isOperating 0 否，1 是
     */
    public void setIsOperating(Integer isOperating) {
        this.isOperating = isOperating;
    }

    /**
     * @return SORT
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * @return SYSTEM_ID
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * @param systemId
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    /**
     * @return ACTIVE
     */
    public Integer getActive() {
        return active;
    }

    /**
     * @param active
     */
    public void setActive(Integer active) {
        this.active = active;
    }

    /**
     * @return CREATE_DATE
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return UPDATE_DATE
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<BaseModuleResources> getSubModules() {
        return subModules;
    }

    public void setSubModules(List<BaseModuleResources> subModules) {
        this.subModules = subModules;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}