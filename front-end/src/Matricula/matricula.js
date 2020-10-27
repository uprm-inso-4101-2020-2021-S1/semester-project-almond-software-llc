import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import Grid from '@material-ui/core/Grid';
import CourseCard from '../CourseCard/coursecard';

const useStyles = makeStyles((theme) => ({
    root: {
        minWidth: 275,
        width: '100%',
    },
    bullet: {
        display: 'inline-block',
        margin: '0 2px',
        transform: 'scale(0.8)',
    },
    title: {
        fontSize: 14,
    },
    pos: {
        marginBottom: 12,
    },
    content: {
        flexGrow: 1,
        padding: theme.spacing(3),
    },
}));

export default function Matricula() {
    const classes = useStyles();

    return (
        <main className={classes.content}>
            <div className={classes.toolbar} />
            <Card className={classes.root}>
                <CardContent>
                    <Typography className={classes.title} color="textSecondary" gutterBottom>2020-2021</Typography>
                    <Divider />
                    <Grid
                        container
                        direction="row"
                        justify="space-around"
                        alignItems="center"
                        style={{ padding: '10px' }}
                    >

                        <div>
                            <div style={{ padding: '10px' }}>
                                <CourseCard />
                            </div>
                            <div style={{ padding: '10px' }}>
                                <CourseCard />
                            </div>
                            <div style={{ padding: '10px' }}>
                                <CourseCard />
                            </div>
                            <div style={{ padding: '10px' }}>
                                <CourseCard />
                            </div>
                        </div>

                        <Divider orientation='vertical' flexItem />

                        <div>
                            <div style={{ padding: '10px' }}>
                                <CourseCard />
                            </div>
                            <div style={{ padding: '10px' }}>
                                <CourseCard />
                            </div>
                            <div style={{ padding: '10px' }}>
                                <CourseCard />
                            </div>
                            <div style={{ padding: '10px' }}>
                                <CourseCard />
                            </div>
                        </div>

                    </Grid>
                </CardContent>
            </Card>
        </main>

    );
}
