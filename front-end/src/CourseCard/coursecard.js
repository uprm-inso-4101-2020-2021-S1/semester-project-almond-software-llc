import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import ErrorOutlineIcon from '@material-ui/icons/ErrorOutline';
import Grid from '@material-ui/core/Grid';

export default function CourseCard(props) {
    return (
        <Card elevation={2} style={{ width: '175px', height: '85px' }}>
            <div style={{ display: 'flex', justifyContent: 'space-around' }}>
                <CardContent >
                    <Grid container direction='column' justify='center'>
                        <Grid item>
                            <Typography style={{ fontSize: 15, fontWeight: "bold" }}>{props.courseCode}</Typography>
                        </Grid>
                        <Grid item>
                            <Typography style={{ fontSize: 10, color: '#7f7f7f' }}>{props.courseName.length > 22 ? props.courseName.substring(0,20)+ '...' : props.courseName}</Typography>
                        </Grid>
                        <Grid item>
                            <Typography style={{ fontSize: 12, color: '#7f7f7f' }}>{props.credits} credits</Typography>
                        </Grid>

                    </Grid>
                </CardContent>
                <div>
                    <Grid container direction='column' justify='center'>
                        <Grid item>
                            <div style={{ backgroundColor: props.color, borderRadius: '50%', width: '15px', height: '15px', margin: '5px' }} />
                        </Grid>
                    </Grid>
                </div>
            </div>
        </Card>
    );
}