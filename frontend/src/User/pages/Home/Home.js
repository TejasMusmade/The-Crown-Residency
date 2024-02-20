import React from "react";
import { useEffect } from "react";
import "./Home.css";
import CarouselContainer from "./CarouselContainer"

function UserHome() {


  return (

        <div  className="App">
        <CarouselContainer />
      </div>
     
    // <section class="bgimage ">
    //   <div class="container position-relative">
    //     <div class="row ">
    //       <div className="col"></div>
    //       <div className="col"></div>
    //       <div class="col-lg ">
    //         <div class="container-fluid text-center ">
    //           <h1 class="display-3 text-dark  ">StarGateWay</h1>
    //           <p >
    //             A perfect place for vacation, relaxation or as a daytime
    //             getaway.Offering dining & an outdoor pool.
    //           </p>
    //           <p>
    //             <a href="#" class="btn btn-primary btn-large">
    //               Book Now »
    //             </a>
    //           </p>
    //         </div>
    //       </div>
    //     </div>
    //   </div>
    // </section>
  );
}

export default UserHome;

// <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
