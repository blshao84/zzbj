package tech.tongyu.core.dto.master;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 主协议
 */
@JsonPropertyOrder({"Name", "Title", "Telephone", "Mobile", "Email"})
public class MasterAgrmtAttachmentDTO {

    /**
     * 填报方业务代姓名
     */
    private String Name;

    /**
     * 职务
     */
    private String Title;

    /**
     * 电话
     */
    private String Telephone;

    /**
     * 手机
     */
    private String Mobile;

    /**
     * 邮箱
     */
    private String Email;

    public MasterAgrmtAttachmentDTO() {}

    public MasterAgrmtAttachmentDTO(String name, String title, String telephone, String mobile, String email) {
        Name = name;
        Title = title;
        Telephone = telephone;
        Mobile = mobile;
        Email = email;
    }

    public MasterAgrmtAttachmentDTO(String name) {
        Name = name;
    }

    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @JsonProperty("Telephone")
    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    @JsonProperty("Mobile")
    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
