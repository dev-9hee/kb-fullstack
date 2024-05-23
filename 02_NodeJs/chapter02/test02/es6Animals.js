export const animals = ['dog', 'cat'];

export function showAnimals() {
  for (let i = 0; i < animals.length; i++) {
    console.log(animals[i]);
  }

  // animals.map(el=>console.log(el));
}
