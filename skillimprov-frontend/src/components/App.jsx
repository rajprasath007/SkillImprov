import logo from '../logo.svg';
import '../styles/App.css';

function App() {

  async function getSample() {
    try {
      let res = await fetch("http://localhost:8080/api/sample");
      let data = await res.json(); // or res.json() if JSON response
      console.log(data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  }

  getSample();

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="http://localhost:8080/api/sample"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
