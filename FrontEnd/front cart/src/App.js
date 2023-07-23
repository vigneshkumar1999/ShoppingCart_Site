import logo from './logo.svg';
import './App.css';
import Home from './components/Home/Home';
import { Admin } from './components/Context/AdminContext';

function App() {
  return (
    <div className="App">
      <Admin>
        <Home/>
      </Admin>
    </div>
  );
}

export default App;
