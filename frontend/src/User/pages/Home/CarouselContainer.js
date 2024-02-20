import React from 'react';
import { Carousel } from 'react-bootstrap';

import image1 from './../../../image/5.jpeg';
import image2 from './../../../image/1.jpg';
import image3 from './../../../image/2.jpg';
import image4 from './../../../image/4.jpg';

const CarouselContainer = () => {
  return (
    <Carousel fade={true} pause={false}>
      <Carousel.Item interval={2000}>
        <img
          className="d-block w-100"
          src={image1}
          alt="First slide"
          // style={{height: "80%"}}
        />
        <Carousel.Caption>
        <h2>The Crown Residency</h2>
          {/* <h3>First slide label</h3>
          <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p> */}
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item interval={2000}>
        <img
          className="d-block w-100"
          src={image2}
          alt="Third slide"
          // style={{height: "80%"}}
        />
        <Carousel.Caption>
        <h2>The Crown Residency</h2>
          {/* <h3>Second slide label</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p> */}
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item interval={2000}>
        <img
          className="d-block w-100"
          src={image3}
          alt="Third slide"
          // style={{height: "80%"}}
        />
        <Carousel.Caption>
        <h2>The Crown Residency</h2>
          {/* <h3>Third slide label</h3>
          <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p> */}
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item interval={2000}>
        <img
          className="d-block w-100"
          src={image4}
          alt="Fourth slide"
          // style={{height: "100%"}}
        />
        <Carousel.Caption>
        <h2>The Crown Residency</h2>
          {/* <h3>Fourth slide label</h3>
          <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p> */}
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
  )
}

export default CarouselContainer;