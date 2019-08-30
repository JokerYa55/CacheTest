/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captcha;

/**
 *
 * @author vasil
 */
public class CaptchaResult {

    private String code;
    private byte[] captcha;

    public CaptchaResult() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getCaptcha() {
        return captcha;
    }

    public void setCaptcha(byte[] captcha) {
        this.captcha = captcha;
    }

    @Override
    public String toString() {
        return "CaptchaResult{" + "code=" + code + '}';
    }

}
