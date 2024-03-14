package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.Date;

public class Application {
    
    private static String Driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/menudb";
    private static String user = "ohgiraffers";
    private static String password = "ohgiraffers";

    public static void main(String[] args) {
        /*필기. 
        *  DB 접속 관한 설정
        *  ------------------------------------------
        *  JdbcTransactionFactory : 수동커밋
        *  ManagedTransactionFactory : 자동커밋
        *  -------------------------------------------
        *  PooledDataSource : ConnectionPool 사용
        *  UnPooledDataSource : ConnectionPool 미사용*/

        Environment environment = new Environment(
                "dev"                         //환경 정보 이름 (id)
                ,new JdbcTransactionFactory() // 트랜잭션 매니저 종류 결정(JDBC or MANAGED)  mysql 의 start transaction 과 유사 managed 는 자동 커밋
                ,new PooledDataSource(Driver,url,user,password)  //ConnectionPool 사용유무 (Pooled or unPooled) 하나의 Connection 이 아닌 여러 Connection 을 만들어준다
        );                                                       // DAO 를 할때 connection 을 close 하지 않았는데 그이유는 Connection 이 하나였기 때문이다
        
        /*필기. 생성한 환경 정보로 MyBatis 설정 객체 생성*/

        Configuration configuration = new Configuration(environment);   // Configuration 은 ibatis 로 임포트 된것을 사용한다

        configuration.addMapper(Mapper.class);
        
        /*필기. 
        *  sqlSessionFactory : sqlSession 객체를 생성하기 위한 팩토리(공장) 역할의 인터페이스
        *  sqlSessionFactoryBuilder : sqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
        *  build() : 환경 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연결된 Stream
        *            을 매개변수로 전달하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 매소드  */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /*필기.
        *  openSession() : sqlSession 인터페이스 타입의 객체를 반환하는 메소드로 boolean 타입을 인자로 전달
        *  - false : Connection 인터페이스 타입 객체로 DML(insert, update, delete) 수행후 autocommit 옵션 false(권장) (mysql 의 set autocommit = false; 와 동일*/

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        /*필기. getMapper() : Configuration 에 등록된 매퍼를 동일 타입에 대해 반환하는 매소드*/
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        java.util.Date date = mapper.selectSysdate();

        System.out.println("date = " + date);



        sqlSession.close();   // 역시나 모든 작업이 끝난후에 닫아주어야한다

        
        
        
        
    }
    
    
    
}
