package com.Demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Demo.model.RegVO;
import com.Demo.model.loginvo;

@Controller

public class Reg_Controller {
	@RequestMapping(value = "Register.html", method = RequestMethod.GET)

	public ModelAndView Register() {

		return new ModelAndView("Register", "data", new RegVO());// view one welcome
	}

	@RequestMapping(value = "Inserted.html", method = RequestMethod.POST)
	public ModelAndView fetch(@ModelAttribute RegVO regvo, HttpSession session) {

		session.setAttribute("keysession", regvo);
		String s3="Registered";
		return new ModelAndView("welcome", "msg", s3);
		/*return new ModelAndView("login", "logInData", new loginvo());*/

		// return new ModelAndView("Register","data",new RegVO());//view one welcome

	}

	@RequestMapping(value = "log.html", method = RequestMethod.GET)

	public ModelAndView log() {

		return new ModelAndView("login", "logInData", new loginvo());// view one welcome
	}

	@RequestMapping(value = "Login.html", method = RequestMethod.POST)

	public ModelAndView login(@ModelAttribute loginvo login, HttpSession session) {

		RegVO s = (RegVO) session.getAttribute("keysession");
		String us = (String) s.getUsername();
		String ps = (String) s.getPassword();

		String s3 = "welcome...";
		if (login.getUn1().equals(us) && login.getPswd1().equals(ps)) {
			return new ModelAndView("welcome", "msg", s3);
		} else {

			return new ModelAndView("login", "logInData", new loginvo());
		}

	}

}