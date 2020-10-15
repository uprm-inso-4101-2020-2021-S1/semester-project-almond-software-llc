import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import ErrorOutlineIcon from '@material-ui/icons/ErrorOutline';
import { Table } from '@material-ui/core';

export default function CourseCard() {

    return (
        <Card variant="outlined" style={{ width: '200px', height: '75px', borderColor: '#707070', fontFamily: 'Times New Roman' }}>
            <div style={{ display: "flex" }}>
                <div style={{ width: 410 }}>
                    <CardContent style={{}}>
                        <Typography>
                            {/* <Table>
                        <td>
                            <span style={{fontSize: 32, fontWeight: "bold"}}>CIIC3001</span>
                            <span style={{fontSize: 20, color: '#7f7f7f', position:"relative", bottom: 4}}> - 001</span>
                            <br></br>
                            <span style={{fontSize: 22, color: '#7f7f7f'}}>Mandatory Class 1</span>
                            <br></br>
                            <span style={{fontSize: 24, color: '#7f7f7f'}}>3 credits</span>
                        </td>
                        <td >
                            <IconButton aria-label="delete" style={{positon:"relative", bottom: 20, left: 40}}>
                                <ErrorOutlineIcon />
                            </IconButton>
                        </td>
                    </Table> */}
                        </Typography>
                    </CardContent>
                </div>
                {/* <div style={{ backgroundColor: '#707070', width: 2 }}></div>
                <div style={{ backgroundColor: '#71a772', width: 38 }}></div> */}
            </div>
        </Card>
    );
}
