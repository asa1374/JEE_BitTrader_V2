//상속 하기전에 간단한 예제 2
function People(name,age,gender,job){
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.job = job;
}

function Customer(name,age,gender,job,grade,custNo){
	People.call(this,name,age,gender,job);
	this.grade = grade;
	this.custNo = custNo;
}

var test1 = (()=>{
	return {main : ()=>{
			let cust = new Customer('이창준','27','남자','개발자','3급','123');
			alert(cust.name +','+cust.age+','+cust.gender+','+cust.job+','+cust.grade+','+cust.custNo);
		}
	};
})();
/*//상속 하기전에 간단한 예제 1
function Prodoct(name,price){
	this.name = name;
	this.price = price;
}
function Food(name, price){
	Prodoct.call(this,name,price);
	this.category = 'food';
}

var test = (()=>{
	return {main : ()=>{
		var foo = new Food('cheese',5);
		alert(foo.name+','+foo.price+','+foo.category);
		alert(foo.name);
		}
	};
})();


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
};*/

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

