package com.ssafy.happyhouse.service;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.MemberDao;
import com.ssafy.happyhouse.dto.Member;

@Service
public class MemberServiceImp implements MemberService {

//	@Autowired
//	private MemberDao dao;
//
//	@Override
//	public Member login(Map<String, String> map) throws Exception {
//		return dao.login(map);
//	}
//
//	@Override
//	public int idCheck(String id, String phone) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.idCheck(id, phone);
//	}
//
//	@Override
//	public void registerMember(Member member) throws Exception {
//		// TODO Auto-generated method stub
//		dao.registerMember(member);
//	}
//
//	@Override
//	public List<Member> listMember() throws Exception {
//		return dao.listMember();
//	}
//
//	@Override
//	public Member getMember(String id) throws Exception {
//		return dao.getMember(id);
//	}
//
//	@Override
//	public void updateMember(Member member) throws Exception {
//		dao.updateMember(member);
//
//	}
//
//	@Override
//	public void deleteMember(String id) throws Exception {
//		dao.deleteMember(id);
//
//	}

	@Autowired
	private MemberDao memberMapper;

	@Override
	public Member login(Member memberDto) throws Exception {
		if (memberDto.getId() == null || memberDto.getPassword() == null)
			return null;
		return memberMapper.login(memberDto);
	}

	@Override
	public Member userInfo(String id) throws Exception {
		return memberMapper.userInfo(id);
	}

	@Override
	public void updateMember(Member memberDto) throws Exception {
		memberMapper.updateMember(memberDto);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		memberMapper.deleteMember(id);
	}

	@Override
	public boolean registerMember(Member memberDto) throws Exception {
		if (memberMapper.check_id(memberDto.getId()) > 0 || memberMapper.check_email(memberDto.getEmail()) > 0)
			return false;
		memberDto.setApproval_key(create_key());
		memberMapper.registerMember(memberDto);
		send_mail(memberDto, "join");
		return true;
	}

	@Override
	public void send_mail(Member memberDto, String div) throws Exception {
		// Mail Server 설정
				String charSet = "utf-8";
				String hostSMTP = "smtp.naver.com";
				String hostSMTPid = "didnlietest@naver.com";
				String hostSMTPpwd = "yks97!023";

				// 보내는 사람 EMail, 제목, 내용
				String fromEmail = "didnlietest@naver.com";
				String fromName = "Spring Homepage";
				String subject = "";
				String msg = "";
				
				if(div.equals("join")) {
					// 회원가입 메일 내용
					subject = "Spring Homepage 회원가입 인증 메일입니다.";
					msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
					msg += "<h3 style='color: blue;'>";
					msg += memberDto.getId() + "님 회원가입을 환영합니다.</h3>";
					msg += "<div style='font-size: 130%'>";
					msg += "하단의 인증 버튼 클릭 시 정상적으로 회원가입이 완료됩니다.</div><br/>";
					msg += "<form method='post' action='http://localhost:8080/happyhouse/member/approval_member'>";
					msg += "<input type='hidden' name='email' value='" + memberDto.getEmail() + "'>";
					msg += "<input type='hidden' name='approval_key' value='" + memberDto.getApproval_key() + "'>";
					msg += "<input type='submit' value='인증'></form><br/></div>";
				}else if(div.equals("find_pw")) {
					subject = "Spring Homepage 임시 비밀번호 입니다.";
					msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
					msg += "<h3 style='color: blue;'>";
					msg += memberDto.getId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
					msg += "<p>임시 비밀번호 : ";
					msg += memberDto.getPassword() + "</p></div>";
				}
				// 받는 사람 E-Mail 주소
				String mail = memberDto.getEmail();
				try {
					HtmlEmail email = new HtmlEmail();
					email.setDebug(true);
					email.setCharset(charSet);
					email.setSSL(true);
					email.setHostName(hostSMTP);
					email.setSmtpPort(587);

					email.setAuthentication(hostSMTPid, hostSMTPpwd);
					email.setTLS(true);
					email.addTo(mail, charSet);
					email.setFrom(fromEmail, fromName, charSet);
					email.setSubject(subject);
					email.setHtmlMsg(msg);
					email.send();
				} catch (Exception e) {
					System.out.println("메일발송 실패 : " + e);
				}
	}

	@Override
	public int check_id(String id) throws Exception {
		return memberMapper.check_id(id);

	}

	@Override
	public int check_email(String email) throws Exception {
		return memberMapper.check_email(email);
	}

	@Override
	public String create_key() throws Exception {
		String key = "";
		Random rd = new Random();

		for (int i = 0; i < 8; i++) {
			key += rd.nextInt(10);
		}
		return key;
	}

	@Override
	public void approval_member(Member memberDto, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (memberMapper.approval_member(memberDto) == 0) { // 이메일 인증에 실패하였을 경우
			out.println("<script>");
			out.println("alert('잘못된 접근입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		} else { // 이메일 인증을 성공하였을 경우
			out.println("<script>");
			out.println("alert('인증이 완료되었습니다. 로그인 후 이용하세요.');");
			out.println("location.href='../board/list';");
			out.println("</script>");
			out.close();
		}
		
	}

	@Override
	public int find_pw(Member memberDto) throws Exception {
		// 아이디가 없으면
		if(memberMapper.check_id(memberDto.getId()) == 0) {
			return 1;
		}
		// 가입에 사용한 이메일이 아니면
		else if(!memberDto.getEmail().equals(memberMapper.userInfo(memberDto.getId()).getEmail())) {
			return 2;
		}else {
			// 임시 비밀번호 생성
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			memberDto.setPassword(pw);
			// 비밀번호 변경
			memberMapper.update_pw(memberDto);
			// 비밀번호 변경 메일 발송
			send_mail(memberDto, "find_pw");
			
			return 3;
		}
		
	}

}
