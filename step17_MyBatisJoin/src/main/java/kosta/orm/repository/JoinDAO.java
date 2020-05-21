package kosta.orm.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.orm.domain.CommentB;
import kosta.orm.domain.Reply;
import kosta.orm.domain.Users;

public class JoinDAO {
	/**
	 * 1:1의 경우
	 */
	public void association() {
		try(SqlSession session = Dbutil.getSession()) {
			List<CommentB> list = session.selectList("joinMapper.associationJoin");
			
			for(CommentB cb : list) {
				System.out.println(cb);
			}
		}
	}
	
	/**
	 * 1 : 다의 경우
	 */
	public void collection() {
		try(SqlSession session = Dbutil.getSession()) {
			List<CommentB> list = session.selectList("joinMapper.collectionJoin");

			System.out.println("갯수 : " + list.size());
			for(CommentB cb : list) {
				System.out.println(cb.getCommentNo() + " | " + cb.getUserId() + " | " + cb.getCommentContent());
				for(Reply r : cb.getReplyList()) {
					System.out.println(r);
				}
			}
		}
	}
	
	public void userCollection() {
		try(SqlSession session = Dbutil.getSession()) {
			List<Users> list = session.selectList("joinMapper.userCollection");

			System.out.println("갯수 : " + list.size());
			for(Users user : list) {
				System.out.println(user.getUserId() + " : " + user.getUserName());
				for(CommentB cb : user.getCommentList()) {
					System.out.println(cb);
				}
			}
		}
	}
}
