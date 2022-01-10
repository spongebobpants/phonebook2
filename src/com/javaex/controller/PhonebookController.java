package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;


@WebServlet("/pbc")
public class PhonebookController extends HttpServlet {

    public PhonebookController() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PhonebookController");
		//컨트롤러 작동 확인
		
		String act = request.getParameter("action");
		System.out.println(act);
		//action=parameter get ex)action=list면 action
//list
		if("list".equals(act)) {
			System.out.println("action=list");
			//parameter 값 list 잘 가져왔는지 확인
			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> personList = phoneDao.getPersonList();
		//System.out.println(personList);
		
		//html, list 섞어서 표현, servlet으로는 표현 불가 --> jsp 이용
		request.setAttribute("personList",personList);
		//별명, 데이터
		
		//personList forward
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
		rd.forward(request, response);
		
//writeForm
		}else if("writeForm".equals(act)) {
			//파라미터값이 writeForm과 같다면
			System.out.println("action=writeForm");
			//forward
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			rd.forward(request, response);
//write
		}else if("write".equals(act)) {
			System.out.println("action=write");
			
			//parameter 4개를 꺼내온다
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			//vo로 만든다
			PersonVo personVo = new PersonVo(name, hp, company);
			System.out.println(personVo);
			//parameter에서 꺼내서 vo에 잘 묶는지 
			
			//dao 메모리 올린다
			PhoneDao phoneDao = new PhoneDao();
			
			//dao.insert(vo);
			phoneDao.personInsert(personVo);
			
			//forward 안 시키고 redirect (response에 넣어주기 )가 더 좋은 방법
			//response.sendRedirect("/phonebook2/pbc?action=list");
//updateForm
		}else if("updateForm".equals(act)) {
			System.out.println("action=update");
			
			//id 형변환
			int id = Integer.parseInt(request.getParameter("id"));
			

//			숫자로 변경한 id로 대상 식별
			PersonVo personVo = new PhoneDao().getPerson(id);
			System.out.println("personVo 출력: "+personVo);
			
//			Action으로 넘어온 값을 변경시킨후 JSP 페이지로 넘겨주기
			request.setAttribute("psnVo", personVo);
			
//			포워드 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateForm.jsp");
			rd.forward(request, response);

			//response.sendRedirect("/phonebook2/pbc?action=list");
//update			
		}else if("update".equals(act)) {
			System.out.println("action=update");
			
			//String id = request.getParameter("id");
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			//형변환
			int personId = Integer.parseInt(request.getParameter("id"));
			System.out.println("수정할번호 "+personId);
			//vo
			PersonVo personVo = new PersonVo(personId, name, hp, company);
			System.out.println(personVo);

			//dao 메모리 올린다
			PhoneDao phoneDao = new PhoneDao();

			//query
			phoneDao.personUpdate(personVo);
			
			//
			//response.sendRedirect("/phonebook2/pbc?action=list");
			
//delete
		}else if("delete".equals(act)){
			//파라미터값이 delete와 같다면
			System.out.println("action=delete");
			
			//id
			String id = request.getParameter("id");
			//parameter 꺼내온다
			int personId =Integer.parseInt(request.getParameter("id"));
			
			//dao 메모리 올린다
			PhoneDao phoneDao = new PhoneDao();
			
			//dao.deleter(Id)
			phoneDao.personDelete(personId);
			
			response.sendRedirect("/phonebook2/pbc?action=list");
			
			
		}else {
			System.out.println("action=null");
			//else -> 아무 파라미터도 찾지 못했을 때 
		}
	}
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
