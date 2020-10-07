import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import Grid from '@material-ui/core/Grid';

const useStyles = makeStyles({
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
});

export default function Matricula() {
    const classes = useStyles();
    const bull = <span className={classes.bullet}>•</span>;

    return (
        <Card className={classes.root}>
            <CardContent>
                <Typography className={classes.title} color="textSecondary" gutterBottom>2020-2021</Typography>
                <Divider />
                <Grid
                    container
                    direction="row"
                    justify="space-around"
                    alignItems="center"
                    style={{ padding: '0px' }}
                >
                    <div>
                        <div style={{ padding: '10px' }}>
                            <Card style={{ width: '150px', height: '50px', }}>
                                <CardContent >
                                    <Typography className={classes.title} color="textSecondary" gutterBottom>CURSO 4200</Typography>
                                </CardContent>
                            </Card>
                        </div>
                        <div style={{ padding: '10px' }}>
                            <Card style={{ width: '150px', height: '50px', }}>
                                <CardContent >
                                    <Typography className={classes.title} color="textSecondary" gutterBottom>CURSO 4200</Typography>
                                </CardContent>
                            </Card>
                        </div>
                        <div style={{ padding: '10px' }}>
                            <Card style={{ width: '150px', height: '50px', }}>
                                <CardContent >
                                    <Typography className={classes.title} color="textSecondary" gutterBottom>CURSO 4200</Typography>
                                </CardContent>
                            </Card>
                        </div>
                        <div style={{ padding: '10px' }}>
                            <Card style={{ width: '150px', height: '50px', }}>
                                <CardContent >
                                    <Typography className={classes.title} color="textSecondary" gutterBottom>CURSO 4200</Typography>
                                </CardContent>
                            </Card>
                        </div>
                    </div>

                    <Divider orientation='vertical' flexItem />

                    <div>
                        <div style={{ padding: '10px' }}>
                            <Card style={{ width: '150px', height: '50px', }}>
                                <CardContent >
                                    <Typography className={classes.title} color="textSecondary" gutterBottom>CURSO 4200</Typography>
                                </CardContent>
                            </Card>
                        </div>
                        <div style={{ padding: '10px' }}>
                            <Card style={{ width: '150px', height: '50px', }}>
                                <CardContent >
                                    <Typography className={classes.title} color="textSecondary" gutterBottom>CURSO 4200</Typography>
                                </CardContent>
                            </Card>
                        </div>
                        <div style={{ padding: '10px' }}>
                            <Card style={{ width: '150px', height: '50px', }}>
                                <CardContent >
                                    <Typography className={classes.title} color="textSecondary" gutterBottom>CURSO 4200</Typography>
                                </CardContent>
                            </Card>
                        </div>
                        <div style={{ padding: '10px' }}>
                            <Card style={{ width: '150px', height: '50px', }}>
                                <CardContent >
                                    <Typography className={classes.title} color="textSecondary" gutterBottom>CURSO 4200</Typography>
                                </CardContent>
                            </Card>
                        </div>
                    </div>

                </Grid>
            </CardContent>
        </Card>
    );
}
