import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import ErrorOutlineIcon from '@material-ui/icons/ErrorOutline';
import Grid from '@material-ui/core/Grid';

function ReturnPx(props) {
    return <div>{props.num}px</div>;
}

export default function ScheduleCard(props) {

    return (
        <Card elevation={2} style={{ width: '500px', height: '300px' }}>
            <Grid container style={{ backgroundColor: 'green', height: '8%', color: 'white' }}>
                <Grid item style={{ textAlign: 'center', width: '14.2857%' }}>◉</Grid>
                <Grid item style={{ textAlign: 'center', width: '14.2857%' }}>MON</Grid>
                <Grid item style={{ textAlign: 'center', width: '14.2857%' }}>TUE</Grid>
                <Grid item style={{ textAlign: 'center', width: '14.2857%' }}>WED</Grid>
                <Grid item style={{ textAlign: 'center', width: '14.2857%' }}>THU</Grid>
                <Grid item style={{ textAlign: 'center', width: '14.2857%' }}>FRI</Grid>
                <Grid item style={{ textAlign: 'center', width: '14.2857%' }}>SAT</Grid>
            </Grid>
            <Grid container style={{ display: 'inline-block', height: '92%', width: '100%', float: 'left' }}>
                <Grid container style={{ height: "100%", borderTop: 'dotted 1px silver' }}>
                    <Grid container style={{ width: '14.2857%', height: '100%', borderLeft: 'dotted 1px silver', position: 'relative', backgroundColor: 'lightgray' }}>
                        <Grid item style={{ textAlign: 'center', height: '25%', width: '100%' }}>6AM</Grid>
                        <Grid item style={{ textAlign: 'center', height: '25%', width: '100%', borderTop: 'dotted 1px white' }}>10AM</Grid>
                        <Grid item style={{ textAlign: 'center', height: '25%', width: '100%', borderTop: 'dotted 1px white' }}>2PM</Grid>
                        <Grid item style={{ textAlign: 'center', height: '25%', width: '100%', borderTop: 'dotted 1px white' }}>6PM</Grid>
                    </Grid>
                    {props.currentMatricula.sectionsByDay.map((day, i) => (
                        <Grid item style={{ width: '14.2857%', height: '100%', borderLeft: 'dotted 1px silver', position: 'relative' }}>
                            {day.map((section, i) => (

                                <Card style={{ backgroundColor: section.color, width: '100%', color: 'white', height: (section.period.end - section.period.start)*0.3 + 'px', top: (section.period.start - 600) * 0.17 + 'px', position: 'absolute' }}>

                                    <Typography style={{ fontSize: '12px', fontWeight: 'bold', textAlign: 'center' }}>
                                        {section.courseCode}
                                    </Typography>

                                </Card>

                            ))}
                        </Grid>
                    ))}
                </Grid>
            </Grid>
        </Card>
    );

}
