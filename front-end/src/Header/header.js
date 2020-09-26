import React, { Component } from 'react';
import Macademia from './macademia.png';
import { Navbar, Nav } from 'react-bootstrap';
import './header.css';

class Header extends Component {
    constructor(props) {
        super(props);
        this.wrapper = React.createRef();
        this.state = {
            students: [
                {
                    name: 'Julia'
                }
            ]
        };
    }
    render() {
        const student = this.state.students;
        return (
            <div>
                < Navbar expand="md" id="Navbar" data-toggle="collapse">

                    <Navbar.Brand href="#home"><img src={Macademia} className="almonds-logo" width="80" height="80" mr="1" /></Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">

                        <Nav className="Nav">
                            <Nav.Link href="#home" id="Nav-Link">Home</Nav.Link>
                            <Nav.Link href="#classes" id="Nav-Link">Classes</Nav.Link>
                            <Nav.Link href="#curriculum" id="Nav-Link">Curriculum</Nav.Link>

                            {/* <Form inline className="Form">
                                <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                                <Button variant="outline-success" id="search-button">Search</Button>
                            </Form> */}

                            {student.map((s) => (
                                < Navbar.Text id = "Navbar-Text"  >
                                    Signed in as: <a href="#login" id="name-link" ref = {this.wrapper}>{s.name}</a>
                                </Navbar.Text>
                            ))}
                        </Nav>
                    </Navbar.Collapse>

                </Navbar>
            </div>


        );
    }

}
export default Header;