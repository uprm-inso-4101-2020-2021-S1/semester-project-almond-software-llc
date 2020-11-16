import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import ErrorOutlineIcon from '@material-ui/icons/ErrorOutline';
import Grid from '@material-ui/core/Grid';

export default function ScheduleCard(props) {

    return (
        <Card elevation={2} style={{ width: '600px', height: '400px' }}>
            <Grid container style={{ backgroundColor: 'green', height: '8%', color: 'white' }}>
                <Grid item style={{ textAlign: 'center', width: '8%', float: 'left' }}>◉</Grid>
                <Grid item style={{ textAlign: 'center', width: '15.33%' }}>MON</Grid>
                <Grid item style={{ textAlign: 'center', width: '15.33%' }}>TUE</Grid>
                <Grid item style={{ textAlign: 'center', width: '15.33%' }}>WED</Grid>
                <Grid item style={{ textAlign: 'center', width: '15.33%' }}>THU</Grid>
                <Grid item style={{ textAlign: 'center', width: '15.33%' }}>FRI</Grid>
                <Grid item style={{ textAlign: 'center', width: '15.33%' }}>SAT</Grid>
            </Grid>
            <Grid container style={{ display: 'inline-block', height: '92%', width: '100%', float: 'left' }}>
                <Grid container style={{ height: '33.33%', borderTop: 'dotted 1px silver' }}>
                    <Grid container style={{ textAlign: 'center', width: '8%', height: '100%', backgroundColor: 'lightgray' }}>06:00</Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                </Grid>
                <Grid container style={{ height: '33.33%', borderTop: 'dotted 1px silver' }}>
                    <Grid container style={{ textAlign: 'center', width: '8%', height: '100%', backgroundColor: 'lightgray' }}>12:00</Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                </Grid>
                <Grid container style={{ height: '33.33%', borderTop: 'dotted 1px silver' }}>
                    <Grid container style={{ textAlign: 'center', width: '8%', height: '100%', backgroundColor: 'lightgray' }}>18:00</Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                    <Grid container style={{ width: '15.33%', height: '100%', borderLeft: 'dotted 1px silver' }}></Grid>
                </Grid>
            </Grid>
        </Card>
    );

}
