//다형성
function People(name,age,gender,job){
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.job = job;
}
People.prototype.setName = name=>{this.name = name;};
People.prototype.setAge = age=>{this.age = age;};
People.prototype.setGender = gender=>{this.gender = gender;};
People.prototype.setJob = job=>{this.job = job;};
People.prototype.getName = ()=>{return this.name;};
People.prototype.getAge = ()=>{return this.age;};
People.prototype.getGender = ()=>{return this.gender;};
People.prototype.getJob = ()=>{return this.job;};

function Customer(grade,custNo){
	People.apply(this,arguments);
	this.grade = grade;
	this.custNo = custNo;
}
Customer.prototype = new People();

Customer.prototype.setName = name=>{
	//this.name ='[닉네입]'+name; 이건 자바문법
	Object.getPrototypeOf(Customer.prototype).setName('[닉네임]'+name);
	};
Customer.prototype.setGrade = grade=>{this.grade = grade;};
Customer.prototype.setCustNo = custNo=>{this.custNo = custNo;};
Customer.prototype.getGrade = ()=>{return this.grade;};
Customer.prototype.getCustNo = ()=>{return this.custNo;};

//추상화 방법 기능으로만 작동하는거는 객체 리터럴을 사용한다.
var test1 = {
		main : ()=>{
		let cust = new Customer();
		cust.setName('이창준');
		cust.setAge('27');
		cust.setGender('남자');
		cust.setJob('개발자');
		cust.setGrade('3급');
		cust.setCustNo('123');
		alert('고객정보 : '+cust.getName() +','+cust.getAge()+','+cust.getGender()+','+cust.getJob()+','+cust.getGrade()+','+cust.getCustNo());
		}
	};

