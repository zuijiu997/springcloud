package zuijiu997.outh2.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BaseRole implements Serializable {
    private String id;

    private String roleCode;

    private String roleName;

    private Date createDate;

    private Date updateDate;

    /**
     * 角色资源
     */
    private List<BaseModuleResources> modules;

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
     * @return ROLE_CODE
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * @param roleCode
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * @return ROLE_NAME
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public List<BaseModuleResources> getModules() {
        return modules;
    }

    public void setModules(List<BaseModuleResources> modules) {
        this.modules = modules;
    }
}