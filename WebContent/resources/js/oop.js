//상속
var inherit = (()=>{
	return {
		main : ()=>{
			let emp = new Employee();
			emp.setSalary("100");
			emp.setPosition("대리");
			alert("급여" + emp.getSalary());
			
			let cus = new Customer();
			cus.setCusNo("10");
			cus.setGrade("A등급");
			alert("등급 번호"+cus.getCusNo());
		}
	};
})();
//자바에서는 인스턴스를 만드는 과정인데 매우 간단하다.
function Employee(){
	let _salary,_position;
	return {
		setSalary :(salary)=>{this._salary = salary;},
		getSalary :()=>{return this._salary;},
		setPosition :(position)=>{this._position = position;},
		getPosition :()=>{return this._position;}
	};
};

function Customer(){
	let _cusNo,_grade;
	return {
		setCusNo :(cusNo)=>{this._cusNo = cusNo;},
		getCusNo :()=>{return this._cusNo;},
		setGrade :(grade)=>{this._grade = grade;},
		getGrade :()=>{return this._grade;}
	};
};

//은닉
/*var encap = (function (){
	var main = ()=>{
		person.setName('트럼프');
		person.setAge('100');
		person.setGender('남');
		person.setJob('대통령');
		alert(person.toString());
	};
	return {main:main};
})();

var person = (()=>{
	let _name,_age,_gender,_job;
	return {
		setName:(name)=>{this._name = name;},
		getName:()=>{return this._name;},
		setAge:(age)=>{this._age = age;},
		getAge:()=>{return this._age;},
		setGender:(gender)=>{this._gender = gender;},
		getGender:()=>{return this._gender;},
		setJob:(job)=>{this._job = job;},
		getJob:()=>{return this._job;},
		toString:()=>{
			return this._name+','+this._age+','+this._gender+','+this._job;
		};
	};
})();*/

