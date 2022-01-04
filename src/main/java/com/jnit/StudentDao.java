package com.jnit;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class StudentDao extends JdbcDaoSupport {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	public void saveStudent(Student x) {
		JdbcTemplate obj = getJdbcTemplate();
		obj.execute("insert into student values(" + x.getSid() + ",'" + x.getSname() + "'," + x.getMarks() + ")");

	}

	public void selectStudent() {
		JdbcTemplate obj = getJdbcTemplate();
		List li = obj.queryForList("select * from student");
		Iterator it = li.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	

	}

}
