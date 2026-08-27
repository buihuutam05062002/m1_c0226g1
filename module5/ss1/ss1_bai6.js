const sv1 = {
  firstName: 'John',
  gender: 'male',
  degree: 'Bachelor',
  english: 'English'
}
const sv2 = {
  Name: 'John',
  gender: 'male',
  degree: 'Bachelor',
  english: 'English'
}

const getInfo = person =>{
    console.log(person.firstName === undefined ? "Quân" : person.firstName )
    console.log(person.degree)
}

getInfo(sv2)