/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captcha;

import com.github.cage.Cage;

/**
 *
 * @author vasil
 */
public class CaptchaFactory {

    private Cage cage;

    private CaptchaFactory() {
    }

    public static CaptchaResult generate() {
        CaptchaResult result = new CaptchaResult();
        return result;
    }
}
