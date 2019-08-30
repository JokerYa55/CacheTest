/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captcha;

import com.github.cage.Cage;
import com.github.cage.GCage;
import com.github.cage.YCage;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author vasil
 */
public class CaptchaFactory {

    private CaptchaFactory() {
    }

    public static CaptchaResult generate(CaptchaType type) {
        CaptchaResult result = new CaptchaResult();
        Cage cage = null;
        switch (type) {
            case BLACK:
                cage = new GCage();
                break;
            case COLOR:
                cage = new YCage();
                break;
        }
        result.setCode(cage.getTokenGenerator().next());
        result.setCaptcha(cage.draw(result.getCode()));
        return result;
    }
}
