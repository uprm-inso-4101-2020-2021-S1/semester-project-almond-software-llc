import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import ErrorOutlineIcon from '@material-ui/icons/ErrorOutline';
import Grid from '@material-ui/core/Grid';

export default function ScheduleCard(props) {

    return (
        <Card elevation={2} style={{ width: '500px', height: '300px' }}>
            <Grid container style={{ backgroundColor: 'green', height: '8%', color: 'white' }}>
                <Grid item style={{ textAlign: 'center', width: '16.666%' }}>MON</Grid>
                <Grid item style={{ textAlign: 'center', width: '16.666%' }}>TUE</Grid>
                <Grid item style={{ textAlign: 'center', width: '16.666%' }}>WED</Grid>
                <Grid item style={{ textAlign: 'center', width: '16.666%' }}>THU</Grid>
                <Grid item style={{ textAlign: 'center', width: '16.666%' }}>FRI</Grid>
                <Grid item style={{ textAlign: 'center', width: '16.666%' }}>SAT</Grid>
            </Grid>
            <Grid container style={{ display: 'inline-block', height: '92%', width: '100%', float: 'left' }}>
                <Grid container style={{ height: "100%", borderTop: 'dotted 1px silver' }}>
                    {props.currentMatricula.sectionsByDay.map((day, i) => (
                        <Grid container style={{ width: '16.666%', height: '100%', borderLeft: 'dotted 1px silver' }}>
                            {day.map((section, i) => (
                                <Grid item>
                                    <Card style={{backgroundColor: section.color, color: 'white' }}>
                                        <Grid container>
                                            <Grid item>
                                                <Typography style={{ fontSize: '14px', fontWeight: 'bold'}}>{section.courseCode}</Typography>
                                            </Grid>
                                            <Grid item>
                                                <Typography style={{ fontSize: '12px'}}>{section.time}</Typography>
                                            </Grid>
                                        </Grid>
                                    </Card>
                                </Grid>
                            ))}
                        </Grid>
                    ))}
                </Grid>
            </Grid>
        </Card>
    );

}
