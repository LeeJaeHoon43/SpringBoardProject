package kr.co.dao;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import kr.co.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void register(MemberVO vo) throws Exception {
		sqlSession.insert("memberMapper.register", vo);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sqlSession.selectOne("memberMapper.login", vo);
	}

	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		sqlSession.update("memberMapper.memberUpdate", vo);
	}

	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		sqlSession.delete("memberMapper.memberDelete", vo);
	}

	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = sqlSession.selectOne("memberMapper.passChk", vo);
		return result;
	}

	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = sqlSession.selectOne("memberMapper.idChk", vo);
		return result;
	}
}
